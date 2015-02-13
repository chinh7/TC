package codeforce;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * Created by chinh on 7/19/14.
 */
public class R242D2B {
    static class City implements Comparable<City>{
        int distanceSquare;
        int population;
        public City(int x, int y, int population){
            this.distanceSquare = x*x+y*y;
            this.population = population;
        }
        public int compareTo(City other){
            return this.distanceSquare-other.distanceSquare;
        }
    }
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int s = Integer.parseInt(st.nextToken());
        City[] cities = new City[n];
        for(int i=0; i<n; i++){
            st = new StringTokenizer(br.readLine());
            cities[i] = new City(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
        }
        Arrays.sort(cities);
        int i = 0;
        while(i<n && s<1000000){
            s+=cities[i].population;
            i++;
        }
        if(s<1000000){
            System.out.println(-1);
        } else{
            System.out.println(Math.sqrt(cities[i-1].distanceSquare));
        }
    }

}