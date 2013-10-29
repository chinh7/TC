package topcoder.dp;

/**
 * Created with IntelliJ IDEA.
 * User: chinh
 * Date: 10/29/13
 * Time: 6:46 PM
 * To change this template use File | Settings | File Templates.
 */
public class YetAnotherTwoTeamsProblem {
    public long count(int[] skill){
        int total=0;
        int max=0;
        for(int value : skill){
            total+=value;
            max=Math.max(value, max);
        }
        int lower = total/2+1;
        int upper = Math.min(max+(total-1)/2, total-1);
        long result=0;
        for(int i=0; i<skill.length; i++){
            int realUpper = Math.min(upper, skill[i]+(total-1)/2);
            long[] numberOfWayToCreate = new long[upper+1];
            numberOfWayToCreate[0] = 1;
            for(int j=0; j<skill.length; j++){
                if(skill[j]>skill[i] || (skill[j]==skill[i] && j>i))
                for(int value=realUpper-skill[j]; value>=0; value--){
                    numberOfWayToCreate[value+skill[j]] += numberOfWayToCreate[value];
                }
            }
            int realLower = Math.max(lower,skill[i]);
            for(int strong=realLower; strong<=realUpper; strong++){
                result+=numberOfWayToCreate[strong-skill[i]];
            }
        }
        return result;
    }
}
