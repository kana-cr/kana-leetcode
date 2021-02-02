package 其他;

import java.util.*;

public class 删除子文件夹 {

    public static List<String> removeSubfolders_it(String[] folder) {
        Arrays.sort(folder);
        List<String> remain = Arrays.asList(folder);
        List<String> list = new ArrayList<>(remain);
        List<String> remove = new ArrayList<>();
        List<String> parents = new ArrayList<>();
        for (String parent : folder) {
            if (remove.contains(parent))
                continue;
            String finalParent = parent + "/";
            Iterator<String> listIterator = list.iterator();
            while (listIterator.hasNext()){
                String next = listIterator.next();
                if (parents.contains(next))
                    continue;
                if (next.equals(parent)) {
                    parents.add(parent);
                    continue;
                }
                if (next.startsWith(finalParent) ) {
                    remove.add(next);
                    listIterator.remove();

                }else {
                    break;
                }
            }
        }
        return list;
    }
            //list.removeIf(next -> next.startsWith(finalParent) && !next.equals(finalParent));


    public List<String> removeSubfolders(String[] folder) {
        Arrays.sort(folder);
        List<String> list = new ArrayList<>();
        list.add(folder[0]);
        for (int i = 1; i < folder.length; i++) {
            String parent = list.get(list.size() - 1) + "/";
            if (!folder[i].startsWith(parent))
                list.add(parent);
        }
        return list;
    }
    public static void main(String[] args) {
     removeSubfolders_it(new String[]{"/a","/a/b","/c/d","/c/d/e","/c/f"});
    }
}
