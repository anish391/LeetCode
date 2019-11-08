Fastest Approach

class Solution {
    public List<Integer> selfDividingNumbers(int left, int right) {
        List<Integer> list = new ArrayList<Integer>();
        for(int i=left;i<=right;i++){
            if(div(i,i))
                list.add(i);
        }
        return list;
    }
    
    public boolean div(int num, int z){
        if(num==0){
            return false;
        }
        else if(num % 10 == 0 || z % 10 == 0) { 
            return false;
        }
        else if(num%(z%10)==0){
            if(z<10)
                return true;
            else
                return div(num,z/10);
        }
        return false;
    }
}


Approach #1

class Solution {
    public List<Integer> selfDividingNumbers(int left, int right) {
        List<Integer> list = new ArrayList<Integer>();
        for(int i=left;i<=right;i++){
            if(i<10){
                list.add(i);
                continue;
            }
            int f = 1;
            int t = i;
            while(t!=0){
                int a = t%10;
                if(a==0){
                    f=0;
                    break;
                }
                if(i%a==0){
                    f=1;
                }
                else{
                    f=0;
                    break;
                }
                t=t/10;
            }
            if(f==1)
                list.add(i);
        }
        return list;
    }
}

Approach #2

class Solution {
    public List<Integer> selfDividingNumbers(int left, int right) {
        List<Integer> list = new ArrayList<Integer>();
        for(int i=left;i<=right;i++){
            if(sd(i))
                list.add(i);
        }
        return list;
    }
    
    public boolean sd(int n){
        for(char c: String.valueOf(n).toCharArray()){
            if(c=='0'||n%(c-'0')>0)
                return false;
        }
        return true;
    }
}