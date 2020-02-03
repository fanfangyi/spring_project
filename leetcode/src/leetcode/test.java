package leetcode;

public class test {
	public int minNumberInRotateArray(int [] array) {
        if(array == null || array.length==0)
           return 0;
        int i = 0;
        int j = array.length-1;
        while(array[i]>array[j])
        {
            if(j - i == 1)
                break;
            int m = array[(i+j)/2];
            if(m>=array[i])
                i=m;
            else
                j=m;
        }
        return array[j];
        
    }
}
