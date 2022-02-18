package com.personal.test01.test001;

public class Equation {

    private Double a;
    private Double b;
    private Double c;

    private Integer rootType;
    private Double root1;
    private Double root2;


    public Equation(Double a, Double b, Double c) {
        this.a = a;
        this.b = b;
        this.c = c;
        this.solving();
    }

    private void solving() {
         Double Δ = (b*b)-(4*a*c);
         if (Δ>0) {
             this.rootType = 2;
             this.root1 = (-b-Math.sqrt(Δ))/(2*a);
             this.root2 = (-b+Math.sqrt(Δ))/(2*a);
             if (root1>root2) {
                 Double mid = root1;
                 root1 = root2;
                 root2 = mid ;
             }
         } else if (Δ==0) {
             this.rootType = 1;
             this.root1 = -b/(2*a);
             this.root2 = -b/(2*a);
         } else {
             this.rootType = 0;
         }
    }

    public void setABC(Double a, Double b, Double c) {
        this.a = a;
        this.b = b;
        this.c = c;
        this.solving();
    }

    @Override
    public String toString() {
        String bs = "";
        String cs = "";
        if (b!=0) {
            bs = String.format("%+.1f",b);
        }
        if (c!=0) {
            cs = String.format("%+.1f",c);
        }
        return a.toString()+"x^2"+ (b==0?"":bs) +"x"+ (c==0?"":cs) +"=0";
    }

    public void showResult() {
        if (this.rootType==0) {
            System.out.println("无实根");
        } else if (this.rootType==1) {
            System.out.println("实根1:"+this.root1);
        } else {
            System.out.println("实根1:"+this.root1+",实根2："+this.root2);
        }
    }
}
