/*
// Employee info
class Employee {
    // It's the unique id of each node;
    // unique id of this employee
    public int id;
    // the importance value of this employee
    public int importance;
    // the id of direct subordinates
    public List<Integer> subordinates;
};
*/
class Solution {
    Map<Integer, Employee> map = new HashMap();
    public int getImportance(List<Employee> employees, int id) {
        for(Employee e: employees){
            map.put(e.id, e);
        }
        return dfs(id);
    }
    
    public int dfs(int id){
        int importance = map.get(id).importance;
        for(int i: map.get(id).subordinates){
            importance += dfs(i);
        }
        return importance;
    }
}