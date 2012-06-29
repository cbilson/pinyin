# pinyin

A clojure wrapper for pinyin4j.

## Usage

In your project.clj:

    [pinyin "0.1.0"]

In your code:

    > (use 'pinyin.core)
    
    > (hanzi->pinyin "我要变成拼音“)
    
    (["wŏ"] ["yào" "yāo"] ["biàn" "pián"] ["chéng"] ["pīn"] ["yīn"])
    
    ;; just taking the first pronunciation is actually pretty bad,
    ;; but just for fun...
    > (->> (hanzi->pinyin "我要变成拼音")
           (map first)
           (interpose " ")
           (apply str))
           
    "wŏ yào biàn chéng pīn yīn"

## License

Copyright © 2012 Chris Bilson

Distributed under the GNU Public License, version 2.
