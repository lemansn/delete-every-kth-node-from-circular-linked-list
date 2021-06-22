/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package odev;

/**
 *
 * @author leman
 */
public class Node {

    int data;   //dugumun pozisyonunu tutmak icin degisken
    Node nextNode;  //bir sonraki dugumu gostermek icin bag sahasi
    
    //data parametrisini alan yapici metot
    public Node(int data) {
        this.data = data;
    }
    
    

}
