class Solution {
    public int romanToInt(String s) {
        int number = 0;
        char prev='A';
        for(char c:s.toCharArray()){
            if(c=='I'){
                number+=1;
                prev = c;
            }
            else if(c=='V'){
                if(prev=='I'){
                    number+=3;
                    prev = c;
                }
                else{
                    number+=5;
                    prev = c;
                }
            }
            else if(c=='X'){
                if(prev=='I'){
                    number+=8;
                    prev = c;
                }
                else{
                    number+=10;
                    prev = c;
                }
            }
            else if(c=='L'){
                if(prev=='X'){
                    number+=30;
                    prev = c;
                }
                else{
                    number+=50;
                    prev = c;
                }
            }
            else if(c=='C'){
                if(prev=='X'){
                    number+=80;
                    prev = c;
                }
                else{
                    number+=100;
                    prev = c;
                }
            }
            else if(c=='D'){
                if(prev=='C'){
                    number+=300;
                    prev = c;
                }
                else{
                    number+=500;
                    prev = c;
                }
            }
            else if(c=='M'){
                if(prev=='C'){
                    number+=800;
                    prev = c;
                }
                else{
                    number+=1000;
                    prev = c;
                }
            }
        }
        return number;
    }
}