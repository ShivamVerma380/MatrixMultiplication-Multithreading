package com.brewingjava.multithreading.horsegame;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.brewingjava.multithreading.R;

import java.util.Date;
import java.util.Random;
import java.util.Timer;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class HorseActivity extends AppCompatActivity {

    private ProgressBar progressBarSH1,progressBarSH2,progressBarSH3,progressBarSH4;
    private ProgressBar progressBarMH1,progressBarMH2,progressBarMH3,progressBarMH4;
    //Used to help us start threads as close to the same time as possible
    static CyclicBarrier gate = null;
    // Display a message, preceded by the name of the current thread
    static void threadMessage(String message) {
        String threadName =
                Thread.currentThread().getName();
        System.out.format("%s: %s%n",
                threadName,
                message);
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_horse);

        getSupportActionBar().hide();

        progressBarSH1 = findViewById(R.id.progressBarSH1);
        progressBarSH2 = findViewById(R.id.progressBarSH2);
        progressBarSH3 = findViewById(R.id.progressBarSH3);
        progressBarSH4 = findViewById(R.id.progressBarSH4);

        progressBarMH1 = findViewById(R.id.progressBarMH1);
        progressBarMH2 = findViewById(R.id.progressBarMH2);
        progressBarMH3 = findViewById(R.id.progressBarMH3);
        progressBarMH4 = findViewById(R.id.progressBarMH4);


        long StartTime = System.currentTimeMillis();

        // Delay, in milliseconds before we interrupt MessageLoop thread (default one hour).
        long patience = 1000 * 60 * 60;

        Horse[] horses = new Horse[]{new Horse("Show Me The Money"), new Horse("American Pharoah"),
                new Horse("Sea Hero"), new Horse("Street Sense")};

        Thread[] threads = new Thread[horses.length];

        gate = new CyclicBarrier(horses.length + 1);

        for (int i = 0; i < horses.length; i++) {
            threads[i] = new Thread(horses[i]);
            threads[i].start();
        }

        //The count on the gate is now met, open the gate and start the race!
        try {
            gate.await();
        } catch (BrokenBarrierException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        threadMessage("Waiting for Horse threads to finish");
        // loop until the last horse/thread finishes

        for (int i = 0; i < horses.length; i++) {
            while (threads[i].isAlive()) {
                threadMessage("Still waiting...");
                // The join method allows one thread to wait for the completion of another.
                // Wait a maximum of 1 second for the thread to finish.
                try {
                    threads[i].join(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                if (((System.currentTimeMillis() - StartTime) > patience)
                        && threads[i].isAlive()) {
                    threadMessage("Tired of waiting!");
                    threads[i].interrupt();
                    // Shouldn't be long now
                    // -- wait indefinitely
                    try {
                        threads[i].join();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
        threadMessage("Finally!");


        long endTime = System.currentTimeMillis();

    }



    private static class Horse implements Runnable {
        private int distanceTravelled = 0;
        private String name = "";

        private static int place = 1;

        Horse(String horseName) {
            name = horseName;
        }

        public void run() {
            try {
                gate.await();
                while (distanceTravelled < 100) {
                    // Pause for 4 seconds
                    Thread.sleep(4000);
                    distanceTravelled += this.gallop();
                    // Print a message
                    if (distanceTravelled < 100) {
                        threadMessage(name + " has galloped " + distanceTravelled + " meters");
                    } else {
                        String placeSuffix;
                        if (place == 1) {
                            placeSuffix = "st";
                        } else if (place == 2) {
                            placeSuffix = "nd";
                        } else if (place == 3) {
                            placeSuffix = "rd";
                        } else {
                            placeSuffix = "th";
                        }
                        threadMessage(name + " has crossed the finish line and finished " + place + placeSuffix);
                        // Increment the static variable. This variable is shared across all instances of horse.
                        place++;
                    }
                }
            } catch (InterruptedException e) {
                threadMessage("I wasn't done!");
            } catch (BrokenBarrierException e) {
                e.printStackTrace();
            }
        }

        private int gallop() {
            Random rand = new Random();
            int upperBound = 15;
            int lowerBound = 6;
            return rand.nextInt(upperBound - lowerBound) + lowerBound;
        }
    }
}