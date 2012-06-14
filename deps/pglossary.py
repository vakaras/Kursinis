#!/usr/bin/python3


import locale


class TeXWriter:
    """ Writer for TeX files.
    """

    def __init__(self, output_file):
        self.output_file = output_file

    def write(self, frmt, *args, **kwargs):
        """ Writes formated string to file.
        """
        self.output_file.write(frmt.format(*args, **kwargs))

    def write_block(self, frmt, *args, **kwargs):
        """ Writes block.
        """
        self.write(''.join(['{{', frmt, '}}']), *args, **kwargs)


class GlossaryEntryWriter(TeXWriter):
    """ Writer for glossary entries.
    """

    def __init__(
            self, output_file, entry_dict, counter, default_language='lt'):
        super(GlossaryEntryWriter, self).__init__(output_file)

        self.entry_dict = entry_dict
        self.default_language = default_language
        self.counter = counter

    @property
    def id(self):
        """ Returns entry id.
        """
        return self.entry_dict['id']

    @property
    def description(self):
        """ Returns description.
        """
        return self.entry_dict['long']

    @property
    def short_description(self):
        """ Returns short description.
        """
        try:
            return self.entry_dict['short']
        except KeyError:
            return self.description

    @property
    def value(self):
        """ Returns value.
        """
        return self.entry_dict['lang'][self.default_language]

    @property
    def translations(self):
        """ Returns translations.
        """
        return dict(
                (code, translation)
                for code, translation in self.entry_dict['lang'].items()
                if code != self.default_language)

    @property
    def label(self):
        """ Returns entry label.
        """
        return 'glossary:{0}'.format(self.id)

    def write(self, *args, **kwargs):
        """ Writes formated string to file.
        """
        kwargs.setdefault('s', self)
        super(GlossaryEntryWriter, self).write(*args, **kwargs)

    def write_label(self):
        """
        """
        self.write('\\pGlossaryLabel{{{s.label}}}{{Ž{s.counter}}}\n')

    def __call__(self):
        """ Prints glossary entry.
        """
        self.write_label()
        self.write_block('\\noindent Ž{s.counter} \\strong{{{s.value}}}')
        self.write('\n{s.description}\n\n')
        for code, translation in sorted(self.translations.items()):
            self.write(
                    '{0}: \\emph{{{1}}}\n\n',
                    {'en': 'Angliškai'}[code],
                    translation)


def main(data_file, tex_file):
    data = eval(open(data_file).read())
    data.sort(key=lambda entry: locale.strxfrm(entry['lang']['lt'].lower()))
    with open(tex_file, 'w') as fp:
        for i, entry in enumerate(data):
            writer = GlossaryEntryWriter(fp, entry, i + 1)
            writer()


if __name__ == '__main__':
    import sys
    main(sys.argv[1], sys.argv[2])
