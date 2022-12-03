package com.brewingjava.multithreading.threads;

public class Thread {

    private String title;

    public Thread() {
    }

    public Thread(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public String toString() {
        return "Thread{" +
                "title='" + title + '\'' +
                '}';
    }
}
