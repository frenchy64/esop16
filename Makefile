all:
	pdflatex icfp15-typedclojure.tex
	# FIXME there are no citations in the appendix so bibtex complains about something
	#bibtex icfp15-typedclojure
	#pdflatex icfp15-typedclojure.tex
	pdflatex -shell-escape small.tex 
	bibtex small
	pdflatex -shell-escape small.tex 

