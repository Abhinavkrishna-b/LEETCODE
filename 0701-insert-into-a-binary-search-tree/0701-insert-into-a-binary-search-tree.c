/**
 * Definition for a binary tree node.
 * struct TreeNode {
 *     int val;
 *     struct TreeNode *left;
 *     struct TreeNode *right;
 * };
 */

struct TreeNode* newNode(int val){
    struct TreeNode* newnode = (struct TreeNode*) malloc(sizeof(struct TreeNode));
    newnode->val = val;
    newnode->left = newnode->right = NULL;
    return newnode;
}
struct TreeNode* insertIntoBST(struct TreeNode* root, int val) {
    if(root == NULL)    return newNode(val);
    if(root->val > val){
        root->left = insertIntoBST(root->left,val);
    }
    else{
        root->right = insertIntoBST(root->right,val);
    }
    return root;
}
//Time- O(n)
//Space- O(n) - callback stack