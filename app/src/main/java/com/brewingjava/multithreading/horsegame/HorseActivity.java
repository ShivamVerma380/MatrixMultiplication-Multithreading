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
//    static CyclicBarrier gate = null;
//    // Display a message, preceded by the name of the current thread
//    static void threadMessage(String message) {
//        String threadName =
//                Thread.currentThread().getName();
//        System.out.format("%s: %s%n",
//                threadName,
//                message);
//    }


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

//        Horse[] horses = new Horse[]{new Horse("Show Me The Money"), new Horse("American Pharoah"),
//                new Horse("Sea Hero"), new Horse("Street Sense")};

//        Thread[] threads = new Thread[horses.length];
//
//        gate = new CyclicBarrier(horses.length + 1);

        long startTime = System.currentTimeMillis();

        while (progressBarSH1.getProgress()<=100){
            progressBarSH1.incrementProgressBy(10);
        }

        while (progressBarSH2.getProgress()<=100){
            progressBarSH2.incrementProgressBy(10);
        }

        while (progressBarSH3.getProgress()<=100){
            progressBarSH3.incrementProgressBy(10);
        }
        while (progressBarSH4.getProgress()<=100){
            progressBarSH4.incrementProgressBy(10);
        }

        Toast.makeText(getApplicationContext(),"Time taken in ms: "+String.valueOf(System.currentTimeMillis()-startTime),Toast.LENGTH_SHORT).show();



    }

//
//
//    private static class Horse implements Runnable {
//        private int distanceTravelled = 0;
//        private String name = "";
//
//        private static int place = 1;
//
//        Horse(String horseName) {
//            name = horseName;
//        }
//
//        public void run() {
//            try {
//                gate.await();
//                while (distanceTravelled < 100) {
//                    // Pause for 4 seconds
//                    Thread.sleep(4000);
//                    distanceTravelled += this.gallop();
//                    // Print a message
//                    if (distanceTravelled < 100) {
//                        threadMessage(name + " has galloped " + distanceTravelled + " meters");
//                    } else {
//                        String placeSuffix;
//                        if (place == 1) {
//                            placeSuffix = "st";
//                        } else if (place == 2) {
//                            placeSuffix = "nd";
//                        } else if (place == 3) {
//                            placeSuffix = "rd";
//                        } else {
//                            placeSuffix = "th";
//                        }
//                        threadMessage(name + " has crossed the finish line and finished " + place + placeSuffix);
//                        // Increment the static variable. This variable is shared across all instances of horse.
//                        place++;
//                    }
//                }
//            } catch (InterruptedException e) {
//                threadMessage("I wasn't done!");
//            } catch (BrokenBarrierException e) {
//                e.printStackTrace();
//            }
//        }
//
//        private static int gallop() {
//            Random rand = new Random();
//            int upperBound = 15;
//            int lowerBound = 6;
//            return rand.nextInt(upperBound - lowerBound) + lowerBound;
//        }
//    }
}