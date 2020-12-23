package design;

/**
 * 要求'isInList'操作为O（1）时间复杂度
 * 要求'isInList'内部操作完全基于内存，不得有网络或文件读取; 对象初始化部分如构造函数则不受此限制(如初始化时可从文件中load ip名单列表)
 * 让此工具所能支持的ip列表数量尽可能大(甚至能否覆盖整个ipv4地址空间?), 内存占用尽可能小
 * 此工具可能在多线程环境被使用（IP库可能边更新、边使用）
 * 考核点：数据结构、计算机基础、多线程
 */
public class MyIpList implements IpList{
    @Override
    public boolean isInList(String ip) {
        return false;
    }
}