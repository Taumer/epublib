package nl.siegmann.epublib.domain;

import nl.siegmann.epublib.service.MediatypeService;
import nl.siegmann.epublib.util.StringUtil;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * A Book's collection of Metadata. In the future it should contain all Dublin Core attributes, for now it contains a
 * set of often-used ones.
 * @author paul
 */
public class Metadata implements Serializable {

    /**
     *
     */
    private static final long serialVersionUID = -2437262888962149444L;

    public static final String DEFAULT_LANGUAGE = "en";

    private boolean autoGeneratedId = true;
    private List<Author> authors = new ArrayList<Author>();
    private List<Author> contributors = new ArrayList<Author>();
    private List<Date> dates = new ArrayList<Date>();
    private List<DcmesElement> languages = new ArrayList<DcmesElement>();
    private List<Meta> metas = new ArrayList<Meta>();
    private List<DcmesElement> rights = new ArrayList<DcmesElement>();
    private List<DcmesElement> titles = new ArrayList<DcmesElement>();
    private List<Identifier> identifiers = new ArrayList<Identifier>();
    private List<DcmesElement> subjects = new ArrayList<DcmesElement>();
    private String format = MediatypeService.EPUB.getName();
    private List<DcmesElement> types = new ArrayList<DcmesElement>();
    private List<DcmesElement> descriptions = new ArrayList<DcmesElement>();
    private List<DcmesElement> publishers = new ArrayList<DcmesElement>();
    private DcmesElement source;
    private List<Link> links = new ArrayList<Link>();
    private Map<String, DcmesElement> dcmesElementMap = new HashMap<String, DcmesElement>();
    private Resource coverImage;

    public Metadata() {
        identifiers.add(new Identifier());
        autoGeneratedId = true;
    }

    public boolean isAutoGeneratedId() {
        return autoGeneratedId;
    }

    /**
     * Metadata properties not hard-coded like the author, title, etc.
     * @return
     */
    public List<Meta> getMetas() {
        return metas;
    }

    public void setMetas(List<Meta> metas) {
        this.metas = metas;
    }

    public Meta addMeta(Meta meta) {
        this.metas.add(meta);
        return meta;
    }

    public Date addDate(Date date) {
        this.dates.add(date);
        return date;
    }

    public List<Date> getDates() {
        return dates;
    }

    public void setDates(List<Date> dates) {
        this.dates = dates;
    }

    public Author addAuthor(Author author) {
        authors.add(author);
        return author;
    }

    public List<Author> getAuthors() {
        return authors;
    }

    public void setAuthors(List<Author> authors) {
        this.authors = authors;
    }

    public Author addContributor(Author contributor) {
        contributors.add(contributor);
        return contributor;
    }

    public List<Author> getContributors() {
        return contributors;
    }

    public void setContributors(List<Author> contributors) {
        this.contributors = contributors;
    }

    public List<DcmesElement> getLanguages() {
        return languages;
    }

    public void setLanguages(List<DcmesElement> languages) {
        this.languages = languages;
    }

    public void setLanguage(DcmesElement language) {
        languages.add(language);
    }

    public List<DcmesElement> getSubjects() {
        return subjects;
    }

    public void setSubjects(List<DcmesElement> subjects) {
        this.subjects = subjects;
    }

    public void setRights(List<DcmesElement> rights) {
        this.rights = rights;
    }

    public List<DcmesElement> getRights() {
        return rights;
    }


    /**
     * Gets the first non-blank title of the book. Will return "" if no title found.
     * @return the first non-blank title of the book.
     */
    public DcmesElement getFirstTitle() {
        if (titles == null || titles.isEmpty()) {
            return null;
        }
        for (DcmesElement title : titles) {
            if (title != null) {
                return title;
            }
        }
        return null;
    }

    public DcmesElement addTitle(DcmesElement title) {
        this.titles.add(title);
        return title;
    }

    public void setTitles(List<DcmesElement> titles) {
        this.titles = titles;
    }

    public List<DcmesElement> getTitles() {
        return titles;
    }

    public DcmesElement addPublisher(DcmesElement publisher) {
        this.publishers.add(publisher);
        return publisher;
    }

    public void setPublishers(List<DcmesElement> publishers) {
        this.publishers = publishers;
    }

    public List<DcmesElement> getPublishers() {
        return publishers;
    }

    public DcmesElement addDescription(DcmesElement description) {
        this.descriptions.add(description);
        return description;
    }

    public void setDescriptions(List<DcmesElement> descriptions) {
        this.descriptions = descriptions;
    }

    public List<DcmesElement> getDescriptions() {
        return descriptions;
    }

    public Identifier addIdentifier(Identifier identifier) {
        if (autoGeneratedId && (!(identifiers.isEmpty()))) {
            identifiers.set(0, identifier);
        } else {
            identifiers.add(identifier);
        }
        autoGeneratedId = false;
        return identifier;
    }

    public void setIdentifiers(List<Identifier> identifiers) {
        this.identifiers = identifiers;
        autoGeneratedId = false;
    }

    public List<Identifier> getIdentifiers() {
        return identifiers;
    }

    public void setFormat(String format) {
        this.format = format;
    }

    public String getFormat() {
        return format;
    }

    public DcmesElement addType(DcmesElement type) {
        this.types.add(type);
        return type;
    }

    public List<DcmesElement> getTypes() {
        return types;
    }

    public void setTypes(List<DcmesElement> types) {
        this.types = types;
    }

    public DcmesElement getSource() {
        return source;
    }

    public void setSource(DcmesElement source) {
        this.source = source;
    }

    public List<Link> getLinks() {
        return links;
    }

    public void setLinks(List<Link> links) {
        this.links = links;
    }

    public void addDcmesMap(String id, DcmesElement element) {
        if (StringUtil.isNotBlank(id)) {
            dcmesElementMap.put(id, element);
        }
    }

    public Map<String, DcmesElement> getDcmesElementMap() {
        return dcmesElementMap;
    }
}
