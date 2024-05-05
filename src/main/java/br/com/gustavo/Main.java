package br.com.gustavo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

class ProcessResult{
    private static Queue<Integer> queue = new LinkedList<>();

    private static void insertValues(int amountOfValues){
        for(int i=1;i<=amountOfValues;i++)
            queue.add(i);
    }

    public static void processAnswer(int amoutOfValues){
        insertValues(amoutOfValues);
        System.out.print("Discarded cards: ");
        while(queue.size() > 1){
            if(queue.size() > 2)
                System.out.print(queue.peek() + ", ");
            else
                System.out.print(queue.peek());
            queue.poll();
            queue.add(queue.peek());
            queue.poll();
        }
        System.out.print("\nRemaining card: " + queue.peek() + "\n");
        queue.clear();
    }
}

public class Main {

    public static void main(String[] args) throws IOException {
        InputStreamReader ir = new InputStreamReader(System.in);
        BufferedReader in = new BufferedReader(ir);

        int amountOfValues = Integer.parseInt(in.readLine());

        while(amountOfValues != 0){
            ProcessResult.processAnswer(amountOfValues);
            amountOfValues = Integer.parseInt(in.readLine());
        }
    }
}