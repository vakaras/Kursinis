package lt.astrauskas.kursinis.e5.writers

import lt.astrauskas.kursinis.e5.interfaces

trait Article extends interfaces.Article {

  def asXML() = {
    <article>
      <title>{title}</title>
      <authors>
        {
          for (author <- authors) yield
          <author>{author}</author>
        }
      </authors>
    </article>
  }

}