(defproject pinyin "0.1.0"
  :description "FIXME: write description"
  :url "http://example.com/FIXME"
  :license {:name "GNU Public License v2"
            :url "http://www.gnu.org/licenses/gpl-2.0.html"}
  :repositories {"local" ~(str (.toURI (java.io.File. ".")))}
  :dependencies [[org.clojure/clojure "1.3.0"]
                 [net.sourceforge.pinyin4j "2.5.0"]])