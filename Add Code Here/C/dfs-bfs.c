
#include<stdio.h>
int n,q[20],s,arr[100],node[20], stack[20],top=0,a[20][20],i=1,j=1,k=0,flag=0,ch=1, front=0,rear=0;
void dfs();
void bfs();
int main()
{
    printf("Enter number of nodes:");
    scanf("%d",&n);
    printf("\nEnter the nodes:");
    for(i=1;i<=n;i++)
    scanf("%d",&node[i]);
    printf("Enter adjacency matrix:\n");
    for(i=1;i<=n;i++)
    for(j=1;j<=n;j++)
    scanf("%d",&a[node[i]][node[j]]);
    printf("1.BFS\n2.DFS\n3.Exit");
    while(ch!=3)
    {
    printf("\nEnter choice:");
    scanf("%d",&ch);
    switch(ch)
    {
        case 1: printf("Enter starting node for traversal:");
               scanf("%d",&s);
                 bfs();

                break;
        case 2: printf("Enter starting node for traversal:");
               scanf("%d",&s);
                dfs();
                break;
        case 3: break;
        default: printf("Invalid choice");
    }
    }
    return 0;
}
void bfs()
{

    q[rear]=s;
    for(i=0;i<n;i++)
    {    k=q[front];
        for(j=1;j<=n;j++)
        {
           if(a[k][node[j]]==1)
            {
               for(int l=0;l<rear;l++)
                   if(q[l]==node[j])
                     {  flag=1;
                        break;
                      }
               if(flag==0)
                { rear+=1;
                  q[rear] =node[j];
                }
             }
            flag=0;
        }
       printf("%d  ",q[front]);
       front++;
    }

}
void dfs()
{ stack[top]=s;
    printf("%d  ",s);
    int l=0;
    arr[l]=s;
    j=1;
  while(1)
    {   k=stack[top];
        for(j=1;j<=n;j++)
        {
            if(a[k][node[j]]==1)
            {
                for(int m=0;m<=l;m++)
                   {
                           if(arr[m]==node[j])
                             { flag=1;
                               break;
                             }
                           else
                             flag=0;
                    }
                if(flag==0)
                 { top++;l++;
                 stack[top]=node[j];
                 arr[l]=node[j];
                 printf("%d  ",node[j]);
                 break; //breaking from  elenent exist searching in arr?? &continuing next adj ==1....
                  }
              }

         }

    if(j==n+1)
          top--;
        if(top==-1)
          break;
    }
}
