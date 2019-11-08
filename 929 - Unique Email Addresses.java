#Approach 1

class Solution {
    public int numUniqueEmails(String[] emails) {
        Set<String> set = new HashSet();
        for(String s: emails){
            int index=0;
            String temp = s;
            int a = temp.indexOf("@");
            while((index = temp.indexOf("."))!=-1 && index<a){
                temp = temp.substring(0,index) + temp.substring(index+1);
                a = temp.indexOf("@");
                System.out.println(temp);
            }
            while((index = temp.indexOf("+"))!=-1 && index<a){
                temp = temp.substring(0,index) + temp.substring(a);
                a = temp.indexOf("@");
                System.out.println(temp);
            }
            set.add(temp);
        }
        return set.size();
    }
}

#Approach 2

class Solution {
    public int numUniqueEmails(String[] emails) {
        Set<String> set = new HashSet();
        for(String s: emails){
            int a = s.indexOf("@");
            String local = s.substring(0,a);
            String rest = s.substring(a);
            int dot = 0;
            if((dot = local.indexOf("+"))!=-1){
                local = local.substring(0,dot);
            }
            local = local.replaceAll("\\.","");
            set.add(local+rest);
        }
        return set.size();
    }
}