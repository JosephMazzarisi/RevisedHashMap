package com.company;
import java.util.HashMap;
public class MyHashMap {
    Node[] buckets;

    public MyHashMap() {
            buckets = new Node[16];
            for(int i = 0; i < 16; i++){
                Node node = new Node(null, null);
                buckets[i] = node;
            }
        }

        public void clear () { //Empties out the existing HashMap
            for(int i = 0; i < buckets.length; i++) {
                buckets[i] = null;
            }
            }


        public boolean isEmpty(){ //Returns true if all indexes are null
            for(int i = 0; i < buckets.length; i++){
                if(buckets[i] == null);
                else
                    return false;
            }
            return true;
        }

        public void put (Object key, Object value) {
            Node node = new Node(value, key);
            int index = calculateIndex(key);
            Node x = buckets[index];
            if (buckets[index].getKey() == null) {
                buckets[index] = node;
            }
            else if (containsKey(key)) {
                System.out.println("Stop for you have reached the point of no return");
            } else {

                    while (x.getNext() != null) {
                        x = x.getNext();
                    }
                    x.setNext(node);
            }
        }


        public void putIfAbsent (Object key, Object value)
        { //It inserts the specified value with the specified key in the map only if it is not already specified.
            boolean keyA = containsKey(key);
            boolean valA = containsValue(value);
            if(keyA && valA) {
                System.out.println("Nice");
            }
            else {
            System.out.println("Not Nice");
                put(key, value);
            }
            }



        public Object remove (Object key, Object value){ //Returns the key/value of item being removed
            Node x = buckets[calculateIndex(key)];
            Object obj = null;
            if(x.getData()==value && x.getKey()==key){
                obj = x.getData();
                buckets[calculateIndex(key)] = x.getNext();
            }
            while (x.getNext() != null) {
                if (x.getNext().getData() == value) {
                    obj = x.getNext().getData();
                    if(x.getNext().getNext()==null)
                        x.clearNext();
                    else
                        x.setNext(x.getNext().getNext());
                }
                else
                x = x.getNext();
            }
            return obj;
        }

        public boolean containsValue (Object value){
            for(int i = 0; i < buckets.length; i++){
                Node x = buckets[i];
                if(x.getData() == value)
                    return true;
                while(x.getNext()!=null) {
                    if (x.getData().equals(value))
                        return true;
                    x = x.getNext();
                }
                }
            return false;
        }

        public boolean containsKey (Object key) {//Works not work on other keys than dog
            Node x = buckets[calculateIndex(key)];
            if(x.getKey().equals(key))
                    return true;
            while (x.getNext()!=null){
                if(x.getKey().equals(key))
                    return true;
                x = x.getNext();
            }
            return false;
        }

        public Object get (Object key) {
            Node x = buckets[calculateIndex(key)];
            if(x.getKey() == key)
                return x.getData();
            while (x.getNext() != null) {
                if (x.getKey() == key) {
                    return x.getData();
                }
            }
            return null;
        }

        public Object getOrDefault (Object key, Object value)
        { //It returns the value to which the specified key is mapped, or defaultValue if the map contains no mapping for the key.
            Object obj = value;
            Node x = buckets[calculateIndex(key)];
            if(x.getKey()==key)
                return x.getData();
            while(x.getNext()!=null){
                if(x.getKey()==key)
                    obj = x.getData();
            }
            return obj;
        }
        public int size () { //Returns size of HashMap
        int count = 0;
            for(int i = 0; i < buckets.length; i++){
                Node x = buckets[i];
                if(x.getData() != null)
                    count++;
                while(x.getNext()!=null){
                    count++;
                    x = x.getNext();
                }
            }
            return count;
        }

        public Object replace (Object key, Object value) { //Return old value being replaced. Returns null if key does not exist already.
            Object obj = null;
            Node x = buckets[calculateIndex(key)];
            if(buckets[calculateIndex(key)].getKey() == key){
                obj = x.getData();
                x.setData(value);
            }
            else {
                while (x.getNext() != null) {
                    if (x.getKey().equals(key)) {
                        obj = x.getData();
                        x.setData(value);
                    }
                    x = x.getNext();
                }
            }
            return obj;
        }

        public void display () { //Outputs all items in Hashmap (should include key and value)
            for(int i = 0; i < buckets.length; i++) {
               System.out.println(" ");
                Node x = buckets[i];

                while (x.getNext() != null) {
                    System.out.print("Data: "+x.getData()+" Key: "+x.getKey());
                    x = x.getNext();
                }
                System.out.print("Data: "+x.getData()+" Key: "+x.getKey());
                System.out.println("");
            }
        }

        public int calculateIndex (Object key){
            //index = hashCode(key) & (n-1)  (where n is the size of the Array)
            int index = key.hashCode() & (buckets.length-1);
            return index;
        }


        public class Node {
            private Object key;
            private Object value;
            private int hash;
            private Node next;

            public Node(Object value, Object key) {
                this.key = key;
                this.value = value;
                next = null;
                if(key != null)
                hash = key.hashCode();
                System.out.println("Node created. hash code is: " + hash);
            }

            public Object getData() {
                return value;
            }

            public Node getNext() {
                return next;
            }

            public int getHash() {
                return hash;
            }
            public Object getKey() {
                return key;
            }

            public void setNext(Node next) {
                    this.next = next;
                  }
                  public void clearNext(){
                next = null;
            }

            public void setData(Object value){
                this.value = value;
            }
        }
    }

