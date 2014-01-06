package codeforce;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * Created with IntelliJ IDEA.
 * User: chinh
 * Date: 12/10/13
 * Time: 6:57 PM
 * To change this template use File | Settings | File Templates.
 */
public class R217D2E {
    static class Data{
        int value, leftPos, rightPos;
        int[] spanAtOffset, trace;
        public Data(int value, int leftPos, int rightPos){
            this.value = value;
            this.leftPos = leftPos;
            this.rightPos = rightPos;
            spanAtOffset = new int[5];
            trace = new int[5];
            Arrays.fill(trace, -1);
        }
        public int getSpan(){
            return rightPos-leftPos+1;
        }
    }
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] a = new int[n];
        ArrayList<Data> data = new ArrayList<Data>();
        int currentValue=0;
        int firstPos=0, lastPos=0;
        for(int i=1; i<=n; i++){
            a[i-1] = Integer.parseInt(st.nextToken());
            if(a[i-1]!=0 && a[i-1]==currentValue){
                lastPos = i;
            }
            if(a[i-1]>currentValue){
                data.add(new Data(currentValue, firstPos, lastPos));
                firstPos=i;
                lastPos=i;
                currentValue=a[i-1];
            }
        }
        data.add(new Data(currentValue,firstPos,lastPos));
        data.get(0).trace[0] = 0;
        for(int i=1; i<data.size(); i++){
            Data entry = data.get(i);
            Data prevEntry = data.get(i-1);
            for(int offset=0; offset<5; offset++){
                if(entry.rightPos+offset>n) break;
                for(int l=Math.max(entry.getSpan()+offset,2); l<=5; l++){
                    if(entry.trace[offset]>=0) break;
                    for(int prevOffset=0; prevOffset<5; prevOffset++){
                        if(prevEntry.trace[prevOffset]>=0){
                            int left=prevEntry.rightPos+prevOffset+1;
                            int right=entry.rightPos+offset-l;
                            int nSlots=right-left+1;
                            int nNumbers=entry.value-prevEntry.value-1;
                            if(nNumbers<0) {System.out.println(-1); return;};
                            if((nNumbers==0 && nSlots==0) || (nNumbers*2<=nSlots && nSlots<=nNumbers*5)){
                                entry.spanAtOffset[offset]=l;
                                entry.trace[offset]=prevOffset;
                                break;
                            }
                        }
                    }
                }
            }
        }
        Data lastEntry = data.get(data.size()-1);
        int traceOffset = -1;
        for(int offset=0; offset<5; offset++){
            if(lastEntry.trace[offset]>=0){
                int remainSlots = n-lastEntry.rightPos-offset;
                if(remainSlots==0 || remainSlots>=2){
                    for(int i=0; i<remainSlots/2; i++){
                        a[lastEntry.rightPos+offset+2*i] = lastEntry.value+i+1;
                        a[lastEntry.rightPos+offset+2*i+1] = lastEntry.value+i+1;
                    }
                    if(remainSlots%2==1) a[n-1]=a[n-2];
                    traceOffset = offset;
                    break;
                }
            }
        }
        if(traceOffset<0){
            System.out.println(-1);
            return;
        }
        int i=data.size()-1;
        while(i>0){
            Data entry = data.get(i);
            Data prevEntry = data.get(i-1);
            int prevTraceOffset = entry.trace[traceOffset];
            int left = prevEntry.rightPos+prevTraceOffset+1;
            int right = entry.rightPos+traceOffset-entry.spanAtOffset[traceOffset];
            for(int j=entry.rightPos+traceOffset; j>=right+1; j--) a[j-1]=entry.value;
            int nSlots=right-left+1;
            int nNumbers=entry.value-prevEntry.value-1;

            if(nNumbers>0){
                int j = left;
                int remainder = nSlots%nNumbers;
                int quota = nSlots/nNumbers;
                for(int k=prevEntry.value+1; k<=prevEntry.value+nNumbers; k++){
                    for(int e=0; e<quota+Math.min(5-quota, remainder); e++){
                        a[(j++)-1] = k;
                    }
                    remainder -= Math.min(5-quota, remainder);
                }
            }
            traceOffset = prevTraceOffset;
            i--;
        }
        System.out.println(a[n-1]);
        for(i=0; i<n; i++)
            if(i==n-1) System.out.println(a[i]); else System.out.print(a[i]+" ");
    }

}
