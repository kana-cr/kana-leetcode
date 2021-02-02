package 其他;

import java.util.Arrays;

//第 i 个人的体重为 people[i]，每艘船可以承载的最大重量为 limit
//每艘船最多可同时载两人，但条件是这些人的重量之和最多为 limit
//返回载到每一个人所需的最小船数。(保证每个人都能被船载)
public class 救生艇 {

    public int numRescueBoats(int[] people, int limit) {
        if (people.length == 0)
            return 0;
        Arrays.sort(people);
        int number = people.length;
        int start = 0;
        int end = people.length - 1;
        while (start <= end){
            if (people[end] + people[start] <= limit){
                number --;
                start ++;
                end --;
            }else {
                end --;
            }
        }
        return number;
    }

}
