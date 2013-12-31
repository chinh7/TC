package codeforce;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

/**
 * Created with IntelliJ IDEA.
 * User: chinh
 * Date: 12/10/13
 * Time: 6:57 PM
 * To change this template use File | Settings | File Templates.
 */

public class R222D1B {

    static int n,m;
    static long s;
    static Student[] students;
    static Bug[] bugs;
    static ArrayList<Student> candidates;

    static class Student implements Comparable<Student>{
        int index, power, demand;
        public Student(int index, int power, int demand){
            this.index = index;
            this.power = power;
            this.demand = demand;
        }
        public int compareTo(Student other){
            if(this.demand!=other.demand) return this.demand-other.demand;
            return this.index-other.index;
        }
    }
    static class Bug{
        int index, complexity;
        public Bug(int index, int complexity){
            this.index = index;
            this.complexity = complexity;
        }
    }

    static boolean valid(int interval, boolean trace){
        PriorityQueue<Student> heap = new PriorityQueue<Student>();
        int i = 0;
        int j = 0;
        long cost = 0;
        if(trace) candidates = new ArrayList<Student>();
        while(i<m){
            while(j<n && students[j].power>=bugs[i].complexity){
                heap.offer(students[j]);
                j++;
            }
            if(heap.isEmpty()) return false;
            Student studentWithLeastDemand = heap.poll();
            cost += studentWithLeastDemand.demand;
            i+=interval;
            if(trace) candidates.add(studentWithLeastDemand);
        }
        return (cost<=s);
    }
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        s = Long.parseLong(st.nextToken());

        students = new Student[n];
        bugs = new Bug[m];
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<m; i++){
            bugs[i] = new Bug(i, Integer.parseInt(st.nextToken()));
        }
        st = new StringTokenizer(br.readLine());
        StringTokenizer st2 = new StringTokenizer(br.readLine());
        for(int i=0; i<n; i++){
            students[i] = new Student(i, Integer.parseInt(st.nextToken()), Integer.parseInt(st2.nextToken()));
        }

        Arrays.sort(bugs, new Comparator<Bug>() {
            @Override
            public int compare(Bug bug, Bug bug2) {
                return bug2.complexity - bug.complexity;
            }
        });
        Arrays.sort(students, new Comparator<Student>() {
            @Override
            public int compare(Student student, Student student2) {
                return student2.power - student.power;
            }
        });

        int l=1, r=m;
        while(l<r){
            int mid = (r-l)/2+l;
            if(valid(mid, false)) r=mid; else l=mid+1;
        }
        if(valid(l, true)){
            System.out.println("YES");
            int pos = 0;
            int[] result = new int[m];
            for(int i=0; i<candidates.size(); i++){
                for(int j=pos; j<Math.min(pos+l, m); j++){
                    result[bugs[j].index] = candidates.get(i).index+1;
                }
                pos+=l;
            }
            for(int i=0; i<m; i++){
                if(i==m-1) System.out.println(result[i]); else System.out.print(result[i]+" ");
            }
        } else{
            System.out.println("NO");
        }
    }

}
