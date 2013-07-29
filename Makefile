all:
	pdflatex schemeworkshop13.tex
	bibtex schemeworkshop13
	pdflatex schemeworkshop13.tex
