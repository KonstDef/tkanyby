package framework;

import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class TextTransformers {
    public static List<String> commaSeparate(String str){
        return List.of(str.split(", "));
    }
    public static <K,V> Map<K, V> connectTestData(List<K> keys, List<V> values){
        Iterator<K> keyIter = keys.iterator();
        Iterator<V> valIter = values.iterator();
        return IntStream.range(0, keys.size()).boxed()
                .collect(Collectors.toMap(i -> keyIter.next(), i -> valIter.next()));
    }
}
