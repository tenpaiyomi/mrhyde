(defproject net.drib/mrhyde "0.5.6-SNAPSHOT"
  :description "mrhyde: cljs <-> js interop"
  :url "https://github.com/dribnet/mrhyde"
  :license {:name "Eclipse Public License"
            :url "http://www.eclipse.org/legal/epl-v10.html"}
  :repositories [["clojars" {:sign-releases false}]]
  :dependencies [[org.clojure/clojure "1.10.1"]
                 [org.clojure/clojurescript "1.10.597"]]
  :min-lein-version "2.9.1"
  :source-paths ["src/clj" "src/cljs"]

  :plugins [[lein-cljsbuild "1.1.7"]]

  :cljsbuild {:builds [{:source-paths ["src/cljs" "src/clj"]
                        :jar true}

                       ; tests - 3 different optimizations
                       {:source-paths ["src/cljs" "src/clj" "test/cljs"]
                        :compiler  {:optimizations :whitespace
                                    :pretty-print true
                                    :print-input-delimiter true
                                    :output-to "public/out/mrhyde_test_whitespace.js"}}
                       {:source-paths ["src/cljs" "src/clj" "test/cljs"]
                        :compiler  {:optimizations :simple
                                    :pretty-print true
                                    :print-input-delimiter true
                                    :output-to "public/out/mrhyde_test_simple.js"}}
                       {:source-paths ["src/cljs" "src/clj" "test/cljs"]
                        :compiler  {:optimizations :advanced
                                    :externs [
                                      "public/d3/d3-externs.js"
                                      "public/dummylib/dummylib-externs.js"
                                    ]
                                    :pretty-print true
                                    :print-input-delimiter true
                                    :output-to "public/out/mrhyde_test_advanced.js"}}
                                    ]})
