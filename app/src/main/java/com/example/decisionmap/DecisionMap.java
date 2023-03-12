package com.example.decisionmap;

import android.content.Context;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.Charset;

public class DecisionMap {
    DecisionNode head;
    DecisionNode tail;

    public DecisionMap(Context applicationContext ) throws FileNotFoundException { //constrcutor that loads up file

        BufferedReader reader = connectDataSet(applicationContext);

        buildUnorderedList(reader);

        buildOrderedMap();
    }

    private void append(DecisionNode newNode) {
        if (this.isEmpty()) {
            this.head = newNode;
            this.tail = newNode;
            this.tail.setLinkedNode(null);
            // this.tail.setLinkedNode((DecisionNode) null);
            return;
        }
        this.tail.setLinkedNode(newNode);
        this.tail = newNode;
    }


    public BufferedReader connectDataSet(Context applicationContext) throws FileNotFoundException { //make connection with decisionmap constrcutor

        InputStream is = applicationContext.getResources().openRawResource(R.raw.data1);
        BufferedReader reader = new BufferedReader(new InputStreamReader(is, Charset.forName("UTF-8")));
        return reader;

//

    }
    public void buildUnorderedList(BufferedReader br) { //pass the file data

        DecisionNode node;
        String line = "";

        try {
            while ((line = br.readLine()) != null) {
                node = buildNode(line);

                append(node);
            }
        } catch (IOException e) {

            e.printStackTrace();

        }
    }


    private void buildOrderedMap() {

        if (this.head != null) {


        DecisionNode nodeLinker;
        nodeLinker = head;
        while (nodeLinker !=null) {


            int choise1ID = nodeLinker.getChoise1ID();
            int choise2ID = nodeLinker.getChoise2ID();

            DecisionNode choise1Node = nodeFetch(choise1ID);
            DecisionNode choise2Node = nodeFetch(choise2ID);
            nodeLinker.setChoise1Node(choise1Node);
            nodeLinker.setChoise2Node(choise2Node);

            nodeLinker = nodeLinker.getLinkedNode();
        }
        //    nodeLinker = nodeLinker.getChoise1Node().getChoise2Node();
         //   nodeLinker = nodeLinker.getChoise2Node();



        }



        this.cleanup();
    }


    private void cleanup() {
        if (this.head != null) {
            DecisionNode currentNode = this.head;

            for(DecisionNode nextNode = this.head.getLinkedNode(); nextNode != null; nextNode = nextNode.getLinkedNode()) {
                currentNode.setLinkedNode((DecisionNode)null);
                currentNode = nextNode;
            }

        }
    }

    private DecisionNode buildNode(String line) {
        String[] stringArray = line.split(",");
        DecisionNode n = new DecisionNode();
        n.setNodeID(Integer.valueOf(stringArray[0]));
        n.setChoise1ID(Integer.valueOf(stringArray[1]));
        n.setChoise2ID(Integer.valueOf(stringArray[2]));
        n.setDescription(stringArray[3]);
        n.setOption(stringArray[4]);
        n.setOption2(stringArray[5]);
        return n;
    }

    public DecisionNode entryPoint() {
        return this.head;
    }

    private DecisionNode nodeFetch(int nodeID) {
        DecisionNode nodeLinker;
        for(nodeLinker = this.head; nodeLinker != null && nodeLinker.getNodeID() != nodeID; nodeLinker = nodeLinker.getLinkedNode()) {
        }

        return nodeLinker;
    }

    private boolean isEmpty() {
        return this.head == null;
    }
}



//public class CustomException extends RuntimeException {
//    public CustomException() {
//        super("Invalid number. Choose between 1 or 2.");
//    }
//
//    public CustomException(String message) {
//        super(message);
//    }


