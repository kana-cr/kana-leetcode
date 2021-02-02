package 剑指offer;

public class 旋转数组的最小数字 {

    public int minArray(int[] numbers) {
        int left = 0;
        int right = numbers.length - 1;
        while(left < right){
            int mid = left + ( (right - left) >> 1 );
            if(mid != 0 && numbers[mid] < numbers[right]) right = mid;
            else if(mid != 0 && numbers[mid] > numbers[right]) left = mid + 1;
            else right--;
        }
        return numbers[left];
    }
}