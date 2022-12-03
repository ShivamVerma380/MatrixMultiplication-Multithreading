package com.brewingjava.multithreading;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.brewingjava.multithreading.threads.Thread;
import com.brewingjava.multithreading.threads.ThreadAdapter;
import com.brewingjava.multithreading.threads.ThreadInterface;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements ThreadInterface {

    private RecyclerView recyclerView;
    private ThreadAdapter threadAdapter;
    private ArrayList<Thread> threads;

    @Override
    protected void onCreate( Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


    }

    @Override
    public void onCardClicked(Thread thread) {

    }
}