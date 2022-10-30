#include <stdio.h>
int main()
{
int poly1[30], poly2[30], sum[100], i, deg1, deg2, temp;
for(i=0; i<30; i++)
{
poly1[i]=0;
poly2[i]=0;
}
printf("Enter the highest degree of first polynomial: ");
scanf("%d", &deg1);
for(i=0; i<=deg1; i++)
{
printf("Enter the coefficient of x^%d: ", i);
scanf("%d", &poly1[i]);
}
printf("Enter the highest degree of second polynomial: ");
scanf("%d", &deg2);
for(i=0; i<=deg2; i++)
{
printf("Enter the coefficient of x^%d: ", i);
scanf("%d", &poly2[i]);
}
if(deg1>=deg2)
temp=deg1;
else
temp=deg2;
/*for(i=0; i<temp; i++)
sum[i]=0;*/
for(i=0;i<=temp; i++)
sum[i]=poly1[i]+poly2[i];

printf("First polynomial: ");
for(i=deg1; i>=0; i--)
{
if(poly1[i]>=0)
{
 if(i==deg1)
{
  printf(" %dx^%d ",poly1[i], i);
  continue; 
}
  printf(" +%dx^%d ",poly1[i], i);
}
else if(poly1[i]<1)
  {
printf("%dx^%d ",poly1[i], i);
}
}

printf("\nSecond polynomial: ");
for(i=deg2; i>=0; i--)
{
if(poly2[i]>=0)
{
 if(i==deg2)
{
  printf(" %dx^%d ",poly2[i], i);
  continue; 
}
  printf(" +%dx^%d ",poly2[i], i);
}
else if(poly2[i]<1)
  {
printf("%dx^%d ",poly2[i], i);
}
}

/*printf("\nSum= ");
for(i=temp; i>=0; i--)
printf("..%d..",sum[i]);*/
printf("\npolynmial: ");
for(i=temp; i>=0; i--)
{
if(sum[i]>=0)
{
 if(i==temp)
{
  printf(" %dx^%d ",sum[i], i);
  continue; 
}
  printf(" +%dx^%d ",sum[i], i);
}
else if(sum[i]<1)
  {
printf("%dx^%d ", sum[i], i);
}
}
return 0;
}
