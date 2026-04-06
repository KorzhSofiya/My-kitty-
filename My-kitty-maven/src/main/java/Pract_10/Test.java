package Pract_10;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Value;

@Data
@NoArgsConstructor
class MyData {
    int value;
}

public class Test {
    public static void main(String[] args) {
        MyData data = new MyData();

        data.setValue(20);
        System.out.println(data.getValue());

    }
}
