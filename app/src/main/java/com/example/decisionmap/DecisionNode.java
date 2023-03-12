package com.example.decisionmap;

public class DecisionNode {
    int nodeID;
    int choise1ID;
    int choise2ID;
    String description;
    String option;
    String option2;
    DecisionNode choise1Node;
    DecisionNode choise2Node;
    DecisionNode linkedNode;

    public DecisionNode() {
    }

    public DecisionNode getLinkedNode() {
        return this.linkedNode;
    }

    public void setLinkedNode(DecisionNode linkedNode) {
        this.linkedNode = linkedNode;
    }

    public int getNodeID() {
        return this.nodeID;
    }

    public void setNodeID(int nodeID) {
        this.nodeID = nodeID;
    }

    public int getChoise1ID() {
        return this.choise1ID;
    }

    public void setChoise1ID(int choise1ID) {
        this.choise1ID = choise1ID;
    }

    public int getChoise2ID() {
        return this.choise2ID;
    }

    public void setChoise2ID(int choise2ID) {
        this.choise2ID = choise2ID;
    }

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getOption() {
        return this.option;
    }

    public void setOption(String option) {
        this.option = option;
    }

    public String getOption2() {
        return this.option2;
    }

    public void setOption2(String option2) {
        this.option2 = option2;
    }

    public DecisionNode getChoise1Node() {
        return this.choise1Node;
    }

    public void setChoise1Node(DecisionNode choise1Node) {
        this.choise1Node = choise1Node;
    }

    public DecisionNode getChoise2Node() {
        return this.choise2Node;
    }

    public void setChoise2Node(DecisionNode choise2Node) {
        this.choise2Node = choise2Node;
    }
}


