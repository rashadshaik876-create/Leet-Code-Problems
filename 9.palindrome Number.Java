class Solution { {
            return false;
        }

        int reversedHalf = 0;
        
        
        while (x > reversedHalf) {
            reversedHalf = reversedHalf * 10 + x % 10;
            x /= 10;
        }

        
        return x == reversedHalf || x == reversedHalf / 10;
    }
}
