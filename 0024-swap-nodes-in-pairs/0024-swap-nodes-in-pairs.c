/**
 * Definition for singly-linked list.
 * struct ListNode {
 *     int val;
 *     struct ListNode *next;
 * };
 */
struct ListNode* swapPairs(struct ListNode* head) {
    if(head == NULL || head->next == NULL){
        return head;
    }

    //We had a dummy pointer node to track the head
    //Note there is a struct memory allocated in heap and dummy and point pointers point to that memory
    //But after the point pointer will move ahead but dummy remains same;
    struct ListNode* dummy = (struct ListNode *)malloc(sizeof(struct ListNode));
    dummy->next = NULL;
    struct ListNode* point = dummy;

    struct ListNode* prev = head;
    struct ListNode* cur = head->next;

    while(prev != NULL && cur != NULL){
        prev->next = cur->next;
        cur->next = prev;

        point->next = cur;
        point =  prev;//Because after swap prev becomes the rightmost node in that pair

        //Update the cur and prev
        prev = point->next;
        cur = (prev != NULL) ? prev->next : NULL;
    }
    struct ListNode* newHead = dummy->next;
    free(dummy);
    return newHead;
}
//Time- O(n)
//Space- O(1)