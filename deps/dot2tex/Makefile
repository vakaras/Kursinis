default: buildout patch

bootstrap.py:
	wget http://svn.zope.org/*checkout*/zc.buildout/trunk/bootstrap/bootstrap.py

bin/buildout: bootstrap.py
	python bootstrap.py

buildout: bin/buildout
	bin/buildout -v

patch: bin/dot2tex
	@echo diff old_file new_file > mods.diff
	#-diff bin/dot2tex dot2tex > mods.diff
	mv bin/dot2tex bin/dot2tex.org
	patch bin/dot2tex.org -i mods.diff -o bin/dot2tex
