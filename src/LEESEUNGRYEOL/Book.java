package LEESEUNGRYEOL;
public class Book {
    int index;
    String title;
    String contents;
    static int page;
    private boolean checkindex(int new_index)
    {
        return(new_index == this.index);
    }
    // 기본생성자.
    public Book()
    {
    }

    // title, contents를 초기화 하는 생성자.
    public Book(String title, String contents)
    {
        this.title = title;
        this.contents = contents;
    }

    // 컨텐츠를 확인하는 메서드 (UpdateContents)
    public void UpdateContents(String contents)
    {
        this.contents = contents;
    }

    // 컨텐츠를 가져오는 메서드 (getContents)
    public String getContents()
    {
        return this.contents;
    }

}

class Page{

}

