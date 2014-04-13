package codeforce;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

/**
 * Created by chinh on 4/13/14.
 */
public class R241D2C {
    static class Booking{
        int index, size, value;
        public Booking(int index, int size, int value){
            this.index = index;
            this.size = size;
            this.value = value;
        }
    }
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int n = Integer.parseInt(br.readLine());
        Booking[] bookings = new Booking[n];
        for(int i=0; i<n; i++){
            st = new StringTokenizer(br.readLine());
            bookings[i] = new Booking(i, Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
        }
        Arrays.sort(bookings, new Comparator<Booking>() {
            @Override
            public int compare(Booking o1, Booking o2) {
                return o2.value-o1.value;
            }
        });
        int k = Integer.parseInt(br.readLine());
        int[] tables = new int[k];
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<k; i++){
            tables[i] = Integer.parseInt(st.nextToken());
        }
        ArrayList<Integer> bookingIndices = new ArrayList<Integer>();
        ArrayList<Integer> tableIndices = new ArrayList<Integer>();
        int result = 0;

        for(Booking booking : bookings){
            int minIndex=-1;
            for(int i=0; i<k; i++){
                if(booking.size<=tables[i]){
                    if(minIndex<0 || tables[i]<tables[minIndex]){
                        minIndex = i;
                    }
                }
            }
            if(minIndex>=0){
                result += booking.value;
                bookingIndices.add(booking.index+1);
                tableIndices.add(minIndex+1);
                tables[minIndex]=0;
            }
        }
        System.out.println(bookingIndices.size() + " " + result);
        for(int i=0; i<bookingIndices.size(); i++){
            System.out.println(bookingIndices.get(i) + " " + tableIndices.get(i));
        }
    }
}
