/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package odev;
import java.util.Scanner;

/**
 *
 * @author leman
 */
public class Quiz3 {
    
    static Node head;  // ilk dugum
    static Node tail;  // son dugum

    static void balonPozisyonuBul(int n, int k) {

        //dairesel liste olusturuluyor
        for (int i = 1; i < n + 1; i++) {

            Node newNode = new Node(i);
            //listin bos olup olmadigi kontrol ediliyor   
            if (head == null) {
                //list bos ise ilk ve son dugum yeni dugume esit oluyor    
                head = newNode;
                tail = newNode;
                newNode.nextNode = head;  //yeni dugumun sonraki dugumu ilk dugum oluyor
            } else {
                //list bos degilse yeni dugum son dugumden sonra gelen dugume ataniyor     
                tail.nextNode = newNode;
                //yeni dugum listin son dugumu oluyor   
                tail = newNode;
                //daieresel bagli liste oldugu icin listin son dugumunun (yani yeni dugum) sonraki dugumu ilk dugum oluyor   
                tail.nextNode = head;
            }

        }
        //dairesel listeden silme islemi yaziliyor

        // mevcut dugum yaratiliyor ve ilk dugume esitleniyor
        Node currentNode = head;

        for (int i = 1; i < n; i++) {
            int count = 1; //k-1 kadar dugum atlamak icin count degiskeni ile sayiyorum 

            //her k ninci dugum kendinden bir sonraki dugume ataniyor ve bu islem n-1 kez yani sonda bir balon kalana kadar tekrarlaniyor
            while (count != k-1 ) {

                currentNode = currentNode.nextNode;
                count++;

            }

            if (tail == head) { // list tek bir elemandan olusmussa geriye null deger kaliyor
                head = null;
                tail = null;
            } else {
                //aksi halde listeden silinecek dugumun sonraki dugumu, silinecek dugumun sonraki dugumunun sonraki dugumune esit eliyor
                currentNode.nextNode = currentNode.nextNode.nextNode;
                if (head == currentNode.nextNode) { //ilk dugum siliniyorsa ilk dugum ilk dugumden sonra gelen dugume ataniyor
                    head = head.nextNode;
                }
                if (tail == currentNode.nextNode) { 
                    //son dugum siliniyorsa mevcut dugum son dugum oluyor
                    tail = currentNode;
                }
            }

            //mevcut dugum silinmis dugumun sonraki dugumune esitleniyor
            currentNode = currentNode.nextNode;

        }

        //n ve k degerleri icin geride patlamadan kalan balon pozisyinu ekrana yazdiriliyor 
        System.out.println("N = " + n +" ve " + "K = " + k + "  için " + currentNode.data + ".pozisyondaki balon patlamadan kalır.");
    }

    
    public static void main(String[] args) {
        
        //kullanicidan veri almak icin scanner yaratiliyor
        Scanner scan = new Scanner(System.in);
        
        System.out.println("Balon sayını giriniz: ");
        int n = scan.nextInt(); //kullanicidan balon sayisi aliniyor
        
        System.out.println("Patlatılacak balonun pozisyonunu giriniz: ");
        int k = scan.nextInt(); //kullanicidan patlatilacak balon pozisyonu aliniyor
        
        //kullanicidan alinan n ve k degerleri static metot olan balonPozisyonuBul metotuna aktariliyor
        balonPozisyonuBul(n,k);
    }

}
