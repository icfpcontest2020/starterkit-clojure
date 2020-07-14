#!/bin/sh

clojure -Srepro -m main "$@" || echo "run error code: $?"
