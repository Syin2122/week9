import java.util.Scanner;

abstract class CollegeStudent {
String name;
double tuition;

```
static final double TRANSPORT_FEE = 12000;

CollegeStudent(String name, double tuition) {
    this.name = name;
    this.tuition = tuition;
}

abstract boolean usesBus();

double getTotalFee() {
    return tuition + (usesBus() ? TRANSPORT_FEE : 0);
}
```

}

class DayScholar extends CollegeStudent {
DayScholar(String name) {
super(name, 40000);
}

```
boolean usesBus() {
    return true;
}
```

}

class Hosteller extends CollegeStudent {
Hosteller(String name) {
super(name, 100000);
}

```
boolean usesBus() {
    return false;
}
```

}

class ScholarshipStudent extends CollegeStudent {
ScholarshipStudent(String name) {
super(name, 20000);
}

```
boolean usesBus() {
    return true;
}
```

}

public class CollegeFeeCounter {
public static void main(String[] args) {
Scanner sc = new Scanner(System.in);
int n = sc.nextInt();
double total = 0;

```
    for (int i = 0; i < n; i++) {
        String type = sc.next().toUpperCase();
        String name = sc.next();

        CollegeStudent student;

        switch (type) {
            case "DAY_SCHOLAR":
                student = new DayScholar(name);
                break;
            case "HOSTELLER":
                student = new Hosteller(name);
                break;
            case "SCHOLAR":
                student = new ScholarshipStudent(name);
                break;
            default:
                continue;
        }

        double fee = student.getTotalFee();
        System.out.printf("%s: %.2f%n", name, fee);
        total += fee;
    }

    System.out.printf("Total Collected: %.2f%n", total);
    sc.close();
}
```

}
