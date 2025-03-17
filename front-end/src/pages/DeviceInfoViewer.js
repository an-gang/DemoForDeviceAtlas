import React, {useEffect, useState} from 'react';
import {Space, Button, Input, Table, Checkbox, Modal, message} from "antd";
import defaultImportData from '../resource/defaultImportData.js';
import http from "../framework/http";

function DeviceInfoViewer() {
    const [importData, setImportData] = useState(defaultImportData)
    const [deviceInfo, setDeviceInfo] = useState();

    const [importModalOpen, setImportModalOpen] = useState();
    const [importModalConfirmLoading, setImportModalConfirmLoading] = useState();
    const [clearButtonLoading, setClearButtonLoading] = useState();
    const [searchButtonLoading, setSearchButtonLoading] = useState();

    const [onlyTablet, setOnlyTablet] = useState(true)
    const [keyword, setKeyword] = useState()
    const [pageSize, setPageSize] = useState(15);
    const [page, setPage] = useState(1);
    const [total, setTotal] = useState();

    useEffect(() => {
        loadDeviceInfo();
    }, [onlyTablet, page, pageSize, keyword]);


    const loadDeviceInfo = async () => {
        const res = await http.get("/deviceInfo/list", {
            params: {
                keyword: keyword,
                onlyTablet: onlyTablet,
                page: page,
                pageSize: pageSize
            }
        });
        if (res.data?.code === 200) {
            setDeviceInfo(res.data.data);
            setTotal(res.data.total);
        } else if (res.data?.code !== 401) {
            message.error(res.data?.msg || "Error, please try again later");
        }
    };

    const importDeviceInfo = async () => {
        setImportModalConfirmLoading(true);

        const res = await http.post("/deviceInfo/import", null, {params: {data: importData}})
        if (res.data?.code === 200) {
            message.success("Data imported successfully");
            setImportModalOpen(false);
            loadDeviceInfo();
        } else if (res.data?.code !== 401) {
            message.error(res.data?.msg || "Error, please try again later");
        }

        setImportModalConfirmLoading(false);
    }

    const truncateDeviceInfo = async () => {
        setClearButtonLoading(true);
        const res = await http.delete("/deviceInfo/truncate");
        if (res.data?.code === 200) {
            message.success("successfully");
            loadDeviceInfo();
        } else if (res.data?.code !== 401) {
            message.error(res.data?.msg || "Error, please try again later");
        }
        setClearButtonLoading(false);
    }

    return (
        <div>
            <Space style={{margin: 10}}>
                <Button type="primary" onClick={() => {
                    setImportModalOpen(true);
                }}>Import</Button>
                <Button type="primary"
                        loading={clearButtonLoading}
                        onClick={truncateDeviceInfo}
                >Clear All</Button>
                <Input.Search
                    placeholder="keyword"
                    allowClear
                    enterButton="Search"
                    loading={searchButtonLoading}
                    onSearch={(value) => {
                        setKeyword(value);
                    }}
                />
                <Checkbox checked={onlyTablet} onClick={() => {
                    setOnlyTablet(!onlyTablet);
                }}>
                    Only Tablet
                </Checkbox>
            </Space>
            <Table dataSource={deviceInfo} rowKey="id" pagination={{
                pageSize: pageSize,
                current: page,
                showSizeChanger: true,
                pageSizeOptions: [5, 10, 15, 20, 30, 50],
                total: total,
                showTotal: (total) => "Total: " + total,
                onChange: (page) => {
                    setPage(page);
                },
                onShowSizeChange: (current, size) => {
                    setPageSize(size);
                }
            }}
            >
                <Table.Column title="ID" dataIndex="id" key="id"/>
                <Table.Column title="Primary Hardware Type" dataIndex="primaryHardwareType" key="primaryHardwareType"/>
                <Table.Column title="Vendor" dataIndex="vendor" key="vendor"/>
                <Table.Column title="Model" dataIndex="model" key="model"/>
                <Table.Column title="OS Name" dataIndex="osName" key="osName"/>
                <Table.Column title="OS Version" dataIndex="osVersion" key="osVersion"/>
                <Table.Column title="Browser Name" dataIndex="browserName" key="browserName"/>
                <Table.Column title="Browser Rendering Engine" dataIndex="browserRenderingEngine"
                              key="browserRenderingEngine"/>
            </Table>
            <Modal
                width={800}
                title={<div style={{height: 20}}/>}
                open={importModalOpen}
                confirmLoading={importModalConfirmLoading}
                onCancel={() => {
                    setImportModalOpen(false);
                }}
                onOk={importDeviceInfo}
            >
                <Input.TextArea
                    style={{height: 700}}
                    value={importData}
                    onChange={(e) => {
                        setImportData(e.target.value)
                    }}
                />
            </Modal>
        </div>
    );
}

export default DeviceInfoViewer;
