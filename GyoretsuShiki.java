import java.util.Scanner;

public class GyoretsuShiki {
    public static void main(String[] args){
        double[][] a;
        int n;

        Scanner sc = new Scanner(System.in);

        System.out.printf("\nn�������s��̍s�񎮂𓱏o���܂��B\n\n");
        System.out.println("�s��̎���������͂��Ă��������B");
        System.out.print("n = ");
        n = sc.nextInt();
        a = new double[n + 1][n + 1];
        System.out.printf("\n�s��̐�������͂��Ă��������B\n");
        a = gyoretsu(a, n, sc);
        sc.close();
        System.out.printf("\n���͂��ꂽ�s��́A\n");
        printGyoretsu(a, n);
        doshutsu(a, n);
    }

    public static double[][] gyoretsu(double[][] a, int n, Scanner sc){
        int i, j;
        
        for(i = 1; i < n + 1; i++){
            for(j = 1; j < n + 1; j++){
                System.out.printf("a[%d][%d] = ", i, j);
                a[i][j] = sc.nextDouble();
            }
        }

        return a;
    }

    public static void printGyoretsu(double[][] a, int n){
        int i, j;

        for(i = 1; i < n + 1; i++){
            System.out.print("| ");
            for(j = 1; j < n + 1; j++){
                System.out.printf("%f ", a[i][j]);
            }
            System.out.println(" |");
        }
    }

    //���O�p�s�������Ă���s�񎮂𓱏o
    public static void doshutsu(double[][] a, int n){
        int i, j, k;
        double piv, piv2;
        double ans = 1.0;
        double b = 1.0;

        for(i = 1; i < n; i++){
            piv = a[i][i];
            b = b * piv;
            for(j = i; j < n + 1; j++){
                a[i][j] = a[i][j] / piv;
            }
            for(j = i + 1; j < n + 1; j++){
                piv2 = a[j][i];
                for(k = i; k < n + 1; k++){
                    a[j][k] = a[j][k] - piv2 * a[i][k];
                }
            }
            ans = ans * a[i][i];
        }
        ans = ans * a[n][n] * b;

        System.out.printf("\n�s��͈ȉ��̉��O�p�s��ɕό`�ł���B\n");
        System.out.printf("(%f) �~\n", b);
        printGyoretsu(a, n);
        System.out.printf("\n���������āA���߂���s�񎮂́A\n%f\n", ans);
    }
}
