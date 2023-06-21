package hoa.can.code.diff;

/**
 * https://leetcode.com/problems/trapping-rain-water/
 */
public class TrappingRainWater {

    public int trap(int[] height) {
        int w = height.length;
        if(w < 3)
            return 0;
        int[] r = new int[w];
        int[] l = new int[w];
        l[0] = height[0];
        r[w-1] = height[w-1];

        for(int i = 1; i< w - 1; i++){
            l[i] = Math.max(height[i], l[i-1]);
        }

        for(int i = w-2; i>0; i--){
            r[i] = Math.max(height[i], r[i+1]);
        }

        int collected = 0;
        for(int i=1; i<w-1; i++){
            int puddle = (Math.min(l[i], r[i]) - height[i]); // intermediate stmt for debugging
            collected += puddle;
        }
        return collected;
    }

    public int trap_shit(int[] height) {
        int left = 0;
        int right = 0;
        boolean downWeWent = false;
        boolean upWeWent = false;
        int collected = 0;
        while(right < height.length -1){
            if(height[left] == 0 && !downWeWent && !upWeWent){
                left++;
                right++;
                continue;
            }
            if(right> 0 && height[right] < height[right-1]){
                downWeWent = true;
                if(upWeWent){

                }
            }
            if(right> 0 && height[right] > height[right-1]){
                upWeWent = true;
                if(downWeWent){
                    if(height[right+1] > height[right]){
                        right++;
                        continue;
                    }
                    //compute the water
                    int puddle = Math.min(height[left],height[right])*((right-left)-1);
                    for(int i = left+1; i< right; i++){
                        puddle -= height[i];
                    }
                    collected +=puddle;
                    left = right;
                    downWeWent = false;
                    upWeWent = false;
                }
            }
            right++;
        }
        return collected;
    }
}
