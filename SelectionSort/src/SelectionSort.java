import java.util.Scanner;
public class SelectionSort {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int i,j,size;
		int arr[]=new int[50],temp;
		
		System.out.println("Enter the array size");
		size=sc.nextInt();
		
		System.out.println("Enter the elements in the array");
		for(i=0;i<size;i++)
		{
			arr[i]=sc.nextInt();
		}
		
		System.out.println("Sorting array by selection sort ");
		for(i=0;i<size;i++)
		{
			for(j=1+i;j<size;j++)
			{
				if(arr[i]>arr[j])
				{
					temp=arr[i];
					arr[i]=arr[j];
					arr[j]=temp;
				}
			}
		}
		System.out.println("Printing the elements in the array");
		for(i=0;i<size;i++)
		{
			System.out.println("");
			System.out.println(arr[i]);;
			System.out.println(" ");
		}
		
		
	}

}
