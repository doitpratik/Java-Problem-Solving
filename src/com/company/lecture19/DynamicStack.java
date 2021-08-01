package com.company.lecture19;

public class DynamicStack extends StackImplemtentation {
    @Override
    public void push(int value) {
        if(isFull()){
            Integer[] temp =new Integer[this.data.length*2];
            for (int i = 0; i < this.data.length; i++) {
                temp[i] = this.data[i];
            }
            this.data = temp;
        }
        super.push(value);
    }

}
