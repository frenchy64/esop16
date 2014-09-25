all:
	pdflatex icfp15-typedclojure.tex
	bibtex icfp15-typedclojure
	pdflatex icfp15-typedclojure.tex
