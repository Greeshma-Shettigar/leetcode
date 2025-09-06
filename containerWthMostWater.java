public class containerWthMostWater {
    public int maxArea(int[] height) {
        int left = 0;
        int right = height.length - 1;
        int maxArea = 0;

        while (left < right) {
            int currentHeight = Math.min(height[left], height[right]);
            int currentWidth = right - left;
            int currentArea = currentHeight * currentWidth;
            maxArea = Math.max(maxArea, currentArea);
            /*Think of it like this:

If the left stick is shorter, then the height of the container is limited by the left stick.

Even if we move the right stick closer, the shorter left stick still keeps the container short → so we won’t get a bigger area.

So, the only hope to get more water is to move the shorter stick (left in this case) inward and try with a taller stick.

Similarly:

If the right stick is shorter (or equal), we move the right pointer. */

            if (height[left] < height[right]) {
                left++;
            } else {
                right--;
            }
        }

        return maxArea;
    }
    
}
/*public int maxArea(int[] height) {
        int maxWater=0;
        int ht,wt;
        for(int i=0;i<height.length;i++){
            for(int j=i+1;j<height.length;j++){
                ht=Math.min(height[i],height[j]);
                wt=j-i;
                int area=ht*wt;
                maxWater=Math.max(maxWater,area);

            }
        }
      return maxWater;  
    } */