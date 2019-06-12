package exam;

import java.util.List;

// TODO: 完成这个类

public class PaginationHelper<I> {

    private List<I> _collection;
    private int _itemsPerPage;

    /**
     * 构造函数包含
     * 1）数组collection，表示需要分页的所有元素
     * 2）数字itemsPerPage，表示每页的元素个数
     */
    public PaginationHelper(List<I> collection, int itemsPerPage) {
        _collection = collection;
        _itemsPerPage = itemsPerPage;
    }

    /**
     * 返回collection中所有元素的个数
     */
    public int itemCount() {

        return  _collection.size();

    }

    /**
     * 返回页数
     */
    public int pageCount() {

        return (int)Math.ceil(itemCount()*1.0/_itemsPerPage);

    }

    /**
     * 返回当前页pageIndex中所包含的元素个数
     * pageIndex从0开始计数
     * 如果pageIndex为非法值则返回-1
     */
    public int pageItemCount(int pageIndex) {

        if(pageIndex >= pageCount() || pageIndex < 0){
            return -1;
        }else if(pageIndex == pageCount() - 1){
            return itemCount() - (_itemsPerPage * (pageCount() - 1));
        }
        else{
            return _itemsPerPage;
        }

    }

    /**
     * 返回第itemIndex个元素所在的页数
     * pageIndex从0开始计数
     * 如果itemIndex为非法值则返回-1
     */
    public int pageIndex(int itemIndex) {

        if(itemIndex >= itemCount() || itemIndex < 0){
            return -1;
        }else{
            return itemIndex/_itemsPerPage;
        }

    }
}