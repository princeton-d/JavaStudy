package org.code_test;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        playerList<? extends player> p = new playerList<player>();
        playerList<? extends player> p2 = new playerList<foward1>();
        playerList<? extends player> p3 = new playerList<defender1>();

        List<foward1> list1 = new List<>();
        ArrayList<foward1> fowardList = list1.getFowardList();
        System.out.println(fowardList.get(0).toString());

        List<defender1> list2 = new List<>();
        ArrayList<defender1> defenderList = list2.getDefenderList();
        System.out.println(defenderList.get(0).toString());

        try {
            p.get(0);
        } catch (Exception e) {
            System.out.println("호출하긴 했음");
        }
    }
}

class player {
    public String toString() {
        return "player";
    }
}

class foward1 extends player {
    public String toString() {
        return "Foward";
    }
}

class defender1 extends player {
    public String toString() {
        return "Defender";
    }
}

class playerList<T extends player> extends List<T> {}

class List<T> {
    public ArrayList<T> list = new ArrayList<>();

    public ArrayList<T> getFowardList() {
        list.add((T) new foward1());
        return list;
    }

    public ArrayList<T> getDefenderList() {
        list.add((T) new defender1());
        return list;
    }

    void add(T position) {
        list.add(position);
    }

    T get(int i) {
        return list.get(i);
    }
}