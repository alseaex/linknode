import java.util.Hashtable;

public class LinkList {

    class Node{
        Node next=null;
        int data;
        public Node(int data){
            this.data=data;
        }
    }
    Node head=null;
    public static void main(String[] args) {
        LinkList linkList=new LinkList();
        linkList.addNode(6);
        linkList.addNode(3);
        linkList.addNode(2);
        linkList.addNode(5);
        linkList.addNode(4);
        linkList.addNode(1);
        linkList.printList();
        System.out.println("----------------------");
//        linkList.delNode(1);
//        linkList.printList();
//        System.out.println("----------------------");
//        linkList.deleteDuplicate(linkList.head);
//        linkList.printList();
        System.out.println("找出倒数第K个");
        System.out.print(linkList.findElem(linkList.head,3).data);
    }
    //增加结点
    public void addNode(int d){
        Node node=new Node(d);
        if(head==null) {
            head = node;
            return;
        }
        Node tmp=head;
        while(tmp.next!=null)
            tmp=tmp.next;
        tmp.next=node;
        return;
    }


    public boolean delNode(int index) {
        if (index < 1 || index > length()) {
            return false;
        }
        if (index == 1) {
            head = head.next;
            return true;
        }
        int i = 2;
        Node preNode = head;
        Node curNode = preNode.next;
        while (curNode != null) {
            if (i == index) {
                preNode.next = curNode.next;
                return true;
            }
            preNode = curNode;
            curNode = curNode.next;
            i++;
        }
        return true;

//此法也行
//        Node tmp=head;
//         for(int i=0;i<index-2;i++)
//         {
//             tmp=tmp.next;
//         }
//        Node delNode=tmp.next;
//        Node preNode=tmp;
//        preNode.next=delNode.next;
    }
    //返回结点长度
    public int length()
    {
        int length=0;
        Node tmp=head;
        while(tmp!=null) {
            length++;
            tmp=tmp.next;
        }
        return length;
    }

public void printList() {
    Node tmp=head;
    while(tmp!=null){
        System.out.println(tmp.data);
        tmp=tmp.next;
    }
}
    //在链表删除重复的结点
       public void deleteDuplicate(Node head){

           Hashtable<Integer,Integer> table=new Hashtable<Integer, Integer>();

           Node tmp= head;
           Node preNode=null;
           while(tmp!=null) {
               if (table.containsKey(tmp.data)) {
                      preNode.next=tmp.next;     //在链表删除重复的结点
               } else {
                   table.put(tmp.data,1);
                   preNode=tmp;
               }
               tmp=tmp.next;
           }
           return;
       }

    //找出倒数第K个节点,复杂度O（n）
    public Node findElem(Node head,int k)
    {
        if(k<1||k>this.length())
            return null;
        Node p1=head;
        Node p2=head;
        for(int i=0;i<k;i++)
            p2=p2.next;
        while(p2!=null){
            p2=p2.next;
            p1=p1.next;

        }
        return p1;
    }


}
